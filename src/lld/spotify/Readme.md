# Spotify functional requirements
spotify is an online music streaming app which allows users to
signup
signup with providers like google, fb
signup using email/phone, password/otp
signin
signin with providers like google, fb
signin using email/phone, password/otp
remember me 
forget password
playlists, songs, podcasts, shows, albums, artists, all
onboarding
ask preferences
multiple language
based on previous selection genres, categories, actors, musician
Recommendation topics based on preference selected
Category wise recommendations list and it contains the following list further
Each track list and its further contains a set of list
Search
in home screen search it has to
show all genres by default
each search will have
top results can be any one of the categories like playlists, songs and so on.
show results under each category
Home
each recommendation list can have its own view
example views
podcast view
playlist view
Player view
selected audio view(meta_data, artist, singers, movie)
lyrics
if user selects an album, plays the album, queue list is filled with all album songs and first one is played.
if user selects a playlist, first songs will be played and all next will be added to queue
if another playlist is selected, old playlist and queue list will be reset, selected playlist will be updated
user can add/remove from the playing queue
user can add it to playlist(can be discussed more on extended reqs)
Create playlist
user can create playlist
user can search song and add it to playlist
existing playlist crud operation
Account
user can update their payment account
user can subscribe to subscription plans and they can cancel anytime


# Relationship question
How user to plan association can be kept?
    keeping it in user entity is simple but violates SRP and also we will end up in same style of adding features to user which is bad practise
    another way is mapping DAO