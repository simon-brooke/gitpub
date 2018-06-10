# Introduction to gitpub

A clojure app to publish git commit messages to ActivityPub, specifically in the first instance to Mastodon.social.

# Format of message:

Messages transmitted shall comprise a series of lines; each line shall comprise a token, followed by a colon, followed by data. The lines shall be as follows:

gitpub: "<name of project>",
url: "<git url of repository>",
branch: "<name of branch>",
commit: "<commit hash>",
message: "<commit message>"

Where the total number of characters in the whole message would exceed the maximum, the commit message shall be truncated.
