package com.app.common.config

class PathConfig {
    object Login {
        const val LoginActivity = "/login/LoginActivity"
        const val LoginConfigActivity = "/login/LoginConfigActivity"
    }

    object Main {
        /**
         *
         */
        const val MainActivity = "/main/MainActivity"

        /**
         *
         */
        const val CommonWebViewActivity = "/main/CommonWebViewActivity"
    }

    object Home {
        const val HomeActivity = "/home/HomeActivity"

        /**
         *
         */
        const val HomeFragment = "/home/HomeFragment"
    }

    object WorkBench {
        const val WorkBenchActivity = "/workbench/WorkBenchActivity"

        /**
         *
         */
        const val WorkBenchFragment = "/workbench/WorkBenchFragment"
    }

    object Me {
        const val MeActivity = "/me/MeActivity"

        /**
         *
         */
        const val MeFragment = "/me/MeFragment"
    }
}