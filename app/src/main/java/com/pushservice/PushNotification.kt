package com.pushservice

import com.google.firebase.messaging.FirebaseMessagingService

class PushNotification : FirebaseMessagingService() {
    override fun onNewToken(p0: String) {
        super.onNewToken(p0)

    }


}