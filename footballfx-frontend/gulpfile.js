var gulp = require('gulp');
var browserify = require('browserify');
var source = require('vinyl-source-stream');

var connect = require('gulp-connect');

gulp.task('connect', function () {
    connect.server({
        root: 'src/',
        port: 4000
    });
});


gulp.task('browserify', function () {
    return browserify('./src/app/app.js')
        .bundle()
        .pipe(source('main.js'))
        .pipe(gulp.dest('./src/'));
});

gulp.task('watch', function () {
    gulp.watch('src/app/**/*.js', ['browserify'])
});

gulp.task('default', ['connect', 'watch']);