plugins {
        id("com.android.application")
            kotlin("android")
}

android {
        compileSdk = 34

            defaultConfig {
                        applicationId = "com.lagradost.cloudstream3.adultswim"
                                minSdk = 21
                                        targetSdk = 34
                                                versionCode = 1
                                                        versionName = "1.0"
            }

                buildTypes {
                            release {
                                            isMinifyEnabled = false
                            }
                }

                    compileOptions {
                                sourceCompatibility = JavaVersion.VERSION_17
                                        targetCompatibility = JavaVersion.VERSION_17
                    }

                        kotlinOptions {
                                    jvmTarget = "17"
                        }
}

dependencies {
        implementation("org.jsoup:jsoup:1.15.3")
}
}
                        }
                    }
                            }
                }
            }
}
}