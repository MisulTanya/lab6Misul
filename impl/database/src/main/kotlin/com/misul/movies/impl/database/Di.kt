package com.misul.movies.impl.database

import com.misul.movies.feature.favorites.FavoritesDataSource
import com.misul.movies.feature.movie.FavoriteMovieDataSource
import com.misul.movies.feature.movie.MovieDataSource
import com.misul.movies.feature.movie.MovieNotesDataSource
import com.misul.movies.feature.recommendations.RecommendationsDataSource
import com.misul.movies.feature.search.SearchDataSource
import org.koin.dsl.module

val searchDataModule = module {
	single<SearchDataSource> {
		SearchRepositoryDataSourceImpl(
			SearchHistoryDatabase.getDatabase(get()).dao(),
			get()
		)
	}
}

val movieDataModule = module {
	single<MovieDataSource> { MovieDataSourceImpl(get()) }

	single<RecommendationsDataSource> { RecommendationsDataSourceImpl(get()) }
}

val movieNotesDataModule = module {
	single<MovieNotesDataSource> {
		MovieNotesDataSourceImpl(MovieNotesDatabase.getDatabase(get()).dao())
	}
}

val favoritesDataModule = module {
	single<FavoritesDataSource> {
		FavoritesDataSourceImpl(FavoritesDatabase.getDatabase(get()).dao())
	}

	single<FavoriteMovieDataSource> {
		FavoritesDataSourceImpl(FavoritesDatabase.getDatabase(get()).dao())
	}
}