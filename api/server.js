import Express from 'express'
var app = Express()

import SpotifyWebHelper from '@jonny/spotify-web-helper';
const helper = SpotifyWebHelper()

const music = {
  "inspirational": "spotify:track:17i5jLpzndlQhbS4SrTd0B",
  "rock": "spotify:track:66lOpKgTyFjOrac4S1s94g",
  "pop": "spotify:track:2Ms3JT7IBpn6ASgIdDGUZm"
}

// ROUTES
app.get('/play', function (req, res) {
  helper.player.play()
  console.log("playing")
  res.send("playing")
});

app.get('/play/:song', function (req, res) {
  const song = req.params.song
  if (song in music) {
    helper.player.play(music[song])
    console.log("playing " + song)
    res.send("playing " + song)
  }
  else {
    helper.player.play()
    console.log("can't find song " + song + ", instead playing whatever is next in queue")
    res.send("can't find song. Instead playing whatever is next in queue")
  }
});

app.get('/pause', function (req, res) {
  helper.player.pause()
  console.log("pausing")
  res.send("pausing")
});

app.get('/status', function (req, res) {
  let status = helper.status

  if (status.playing == false){
      res.send("Nothing");
  }
  else {
    res.send(composeMessage(status));
  }
});

// SERVER
var server = app.listen(3000, function () {
  var host = server.address().address;
  host = (host === '::' ? 'localhost' : host);
  var port = server.address().port;

  console.log('listening at http://%s:%s', host, port);
});


// PLAYBACK EVENTS
helper.player.on('error', err => {
  console.log(err)
})

helper.player.on('ready', () => {
  console.log("player ready")
});

// Misc

function composeMessage(status) {
  return status.track.track_resource.name + ' with ' + status.track.artist_resource.name
}

// Playback events
/*helper.player.on('play', () => { });
helper.player.on('pause', () => { });
helper.player.on('end', () => { });
helper.player.on('track-will-change', track => {});
helper.player.on('status-will-change', status => {});
*/

// Playback control. These methods return promises
/*helper.player.play('spotify:track:213342152345');
helper.player.pause();
helper.player.seek();
*/
// Get current playback status, including up to date playing position
// 'status': {
//      'track': ...,
//      'shuffle': ...,
//      'playing_position': ...
//  }
