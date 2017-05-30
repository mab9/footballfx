var gulp = require('gulp');

var connect = require('gulp-connect');

gulp.task('connect', function () {
    connect.server({
        root: 'src/',
        port: 4000
    });
});
