# 🎬 Moviqo - Modern Movie Discovery App

![Kotlin](https://img.shields.io/badge/Kotlin-100%25-orange?style=for-the-badge&logo=kotlin)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-4285F4?style=for-the-badge&logo=android)
![Architecture](https://img.shields.io/badge/Architecture-MVVM%20%2B%20Clean-green?style=for-the-badge)

**Moviqo** is a modern, immersive Android application designed for movie enthusiasts. Built entirely with **Jetpack Compose**, it offers a premium user experience featuring trending movies, a TikTok-style "Shorts" player for trailers, and offline watchlist capabilities.

## 📱 Screenshots

| Home Screen | Shorts (Trailers) | Movie Details |
|:---:|:---:|:---:|
| <img src="img/home.jpg" width="250"/> | <img src="img/shorts.jpg" width="250"/> | <img src="img/details.jpg" width="250"/> |

| Search & Explore | Watchlist | Settings |
|:---:|:---:|:---:|
| <img src="img/search.jpg" width="250"/> | <img src="img/watchlist.jpg" width="250"/> | <img src="img/settings.jpg" width="250"/> |

## ✨ Key Features

* **🔥 Trending Movies:** Browse the latest and most popular movies using infinite scrolling (Paging 3).
* **▶️ Movie Shorts:** A unique, vertical swipe video player (TikTok-style) to watch movie trailers instantly.
* **🔍 Smart Search:** Real-time search functionality to find movies by title.
* **❤️ Watchlist (Offline):** Save your favorite movies locally using Room Database.
* **🎨 Dynamic UI:** Immersive dark-themed UI inspired by top streaming platforms.
* **🛠️ Modern Architecture:** Built using MVVM with Clean Architecture principles ensuring scalability.

## 🛠️ Tech Stack & Libraries

* **Language:** Kotlin (100%)
* **UI Toolkit:** Jetpack Compose (Material 3)
* **Dependency Injection:** Hilt (Dagger)
* **Network:** Retrofit 2 & OkHttp (TMDB API)
* **Asynchronous:** Coroutines & Flow
* **Local Database:** Room
* **Pagination:** Paging 3
* **Image Loading:** Coil
* **Video Player:** Android YouTube Player API
* **Navigation:** Compose Navigation

## ⚙️ Setup & Installation

To run this project locally, you need an API Key from [TMDB](https://www.themoviedb.org/).

1.  Clone the repository:
    ```bash
    git clone [https://github.com/YourUsername/Moviqo.git](https://github.com/YourUsername/Moviqo.git)
    ```
2.  Open the project in **Android Studio**.
3.  Navigate to `ui/util/Constants.kt`.
4.  Replace the placeholder with your API Key:
    ```kotlin
    const val API_KEY = "YOUR_TMDB_API_KEY_HERE"
    ```
5.  Sync Gradle and Run the app! 🚀

## 🤝 Contribution

Contributions are welcome! If you find a bug or want to add a feature, feel free to open an issue or submit a pull request.

## 📜 License

This project is licensed under the MIT License.

Notion : https://wholesale-wallet-b2d.notion.site/Moviqo-Project-Documentation-2df0765c54638060bcc6effc3bae0cf3?source=copy_link

<div align="center">
  Built with ❤️ by <a href="https://www.linkedin.com/in/your-profile">MD. AL MUHEETU</a>
</div>
