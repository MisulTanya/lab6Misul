package com.misul.movies

import android.app.Application
import com.misul.movies.data.favorites.favoritesRepositoryModule
import com.misul.movies.data.movie.movieNotesRepositoryModule
import com.misul.movies.data.movie.movieRepositoryModule
import com.misul.movies.data.search.searchRepositoryModule
import com.misul.movies.feature.favorites.favoriteVMModule
import com.misul.movies.feature.movie.movieVMModule
import com.misul.movies.feature.recommendations.recommendationsVMModule
import com.misul.movies.impl.database.favoritesDataModule
import com.misul.movies.impl.database.movieDataModule
import com.misul.movies.impl.database.movieNotesDataModule
import com.misul.movies.impl.database.searchDataModule
import com.misul.movies.impl.network.moviesClientModule
import com.misul.movies.impl.network.networkClientModule
import com.misul.movies.impl.network.searchClientModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidContext(this@App)
			modules(
				favoritesDataModule,
				favoritesRepositoryModule,
				movieDataModule,
				movieRepositoryModule,
				searchDataModule,
				searchRepositoryModule,
				movieNotesDataModule,
				movieNotesRepositoryModule,

				networkClientModule,
				searchClientModule,
				moviesClientModule,

				recommendationsVMModule,
				movieVMModule,
				favoriteVMModule,
			)
		}
	}
}