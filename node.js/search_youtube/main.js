const ytSearch = require('yt-search')

ytSearch('tool parabola', function (err, r) {
    if (err) throw err

    const videos = r.videos
    const playlists = r.playlists
    const accounts = r.accounts

    const firstResult = videos[0]


    console.log(firstResult)
})