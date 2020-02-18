package com.apap.tu03.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.apap.tu03.model.MovieModel;

@Service
public class InMemoryMovieService implements MovieService{
	private List<MovieModel> archiveMovie;
	
	public InMemoryMovieService() {
		archiveMovie = new ArrayList<>();
	}
	
	@Override
	public void addMovie(MovieModel movie) {
		archiveMovie.add(movie);
	}
	
	@Override
	public void updateMovie (String id, Integer upDuration) {
		for (MovieModel movie : archiveMovie) {
            if(id.equals(movie.getId())) {
                movie.setDuration(upDuration);
            }
		}
	}
	
	@Override
	public void deleteMovie(MovieModel movie) {
        archiveMovie.remove(movie);
	}

	@Override
	public java.util.List<MovieModel> getMovieList() {
		return archiveMovie;
	}

	@Override
	public MovieModel getMovieDetail(String id) {
		for (MovieModel movie: archiveMovie) {
			if (id.equals(movie.getId())) {
				return movie;
			}
		}
		return null;
	}
}
