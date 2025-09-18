package com.template.core.util.google

import android.app.Activity
import android.util.Log
import com.google.android.play.core.review.ReviewManagerFactory
import com.google.android.play.core.review.testing.FakeReviewManager

private const val TAG: String = "InAppReviewExt"

fun Activity.launchInAppReview(
    isTest: Boolean = true,
    onComplete: (() -> Unit)? = null,
    onError: ((e: Exception) -> Unit)? = null
) {
    val manager = if (isTest) {
        FakeReviewManager(this)
    } else {
        ReviewManagerFactory.create(this)
    }
    val request = manager.requestReviewFlow()
    request.addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val reviewInfo = task.result
            Log.d(TAG, reviewInfo.toString())
            val flow = manager.launchReviewFlow(this, reviewInfo)
            flow.addOnCompleteListener {
                // The flow has finished. The API doesn't indicate whether the user
                // reviewed or not, or even whether the review dialog was shown.
                // Therefore, no matter the result, continue with your app's flow.
                onComplete?.invoke()
            }
        } else {
            onError?.invoke(task.exception as Exception)
        }
    }
}