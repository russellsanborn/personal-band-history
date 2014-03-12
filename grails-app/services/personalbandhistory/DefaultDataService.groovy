package personalbandhistory

import org.joda.time.LocalDate

class DefaultDataService {
    
    AlbumService albumService
    BandService bandService
    SongService songService
    ConcertService concertService
    
    def loadDefaultDevData() {
        
        // Create test bands
        Band deathByBobcat = bandService.createBand(new CreateBandCommand(
            bio: "Flint, MI Punk Rock",
            name: "Death By Bobcat",
            location: "Flint, MI",
            startDate: new LocalDate(2000, 07, 04),
            endDate: new LocalDate(2009, 12, 25))
        )
        
        bandService.createBand(new CreateBandCommand(
            bio: "We're Better Than You",
            name: "The Hypocrites",
            location: "Houghton, MI",
            startDate: new LocalDate(2002, 11, 07),
            endDate: new LocalDate(2005, 05, 30))
        )
        
        bandService.createBand(new CreateBandCommand(
            bio: "FTL or Die",
            name: "Totally Harsh",
            location: "Minneapolis, MN",
            startDate: new LocalDate(2007, 1, 1),
            endDate: new LocalDate(2009, 2, 2))
        )
        
        // create test songs
        songService.createSong(new CreateSongCommand(
            name: "Battlestations",
            lyrics: "man the battlestations",
            trackNum: 6)
        )
        songService.createSong(new CreateSongCommand(
            name: "Turnpikes",
            lyrics: "more lyrics put here",
            trackNum: 2)
        )
        songService.createSong(new CreateSongCommand(
            name: "FTL or Die",
            lyrics: "even more lyrics",
            trackNum: 3)
        )
        
        // Create album and add songs/members to it
        Album weGotANuke = albumService.createAlbum(new CreateAlbumCommand(
            name: "We Got A Nuke",
            releaseDate: new LocalDate(2004, 9, 25),
            band: deathByBobcat)
        )
        
        albumService.addSong(weGotANuke, "Intro Song", "lyrics", 1)
        albumService.addSong(weGotANuke, "Turnpikes", "lyrics", 2)
        albumService.addSong(weGotANuke, "Pay The Price", "lyrics", 3)
        albumService.addSong(weGotANuke, "Roynormous", "lyrics", 4)
        albumService.addSong(weGotANuke, "You Wouldn't Know Art If It Hit You In The Face", "lyrics", 5)
        albumService.addSong(weGotANuke, "3,2,1,1 Yeah", "lyrics", 6)
        albumService.addSong(weGotANuke, "Fight For Your Right", "lyrics", 7)
        albumService.addSong(weGotANuke, "We Got A Nuke", "lyrics", 8)
        albumService.addSong(weGotANuke, "Don Carter Lanes", "lyrics", 9)
        albumService.addSong(weGotANuke, "Battle Song", "lyrics", 10)
        albumService.addSong(weGotANuke, "I Wanna Be In Takeout", "lyrics", 11)
        albumService.addSong(weGotANuke, "Punk By The Numbers", "lyrics", 12)
        albumService.addSong(weGotANuke, "Outro Part 2", "lyrics", 13)
        
        albumService.addMember(weGotANuke, "Russell", "Guitar/Vocals", null, null)
        albumService.addMember(weGotANuke, "Mike", "Drums/Vocals", null, null)
        albumService.addMember(weGotANuke, "Derek", "Bass/Vocals", null, null)
        
        concertService.createConcert(new CreateConcertCommand(
                eventDate: new LocalDate(2000,1,1),
                title: "title1",
                venueName: "Flint Local 432",
                location: "Flint, MI"
            )
        )
        
        concertService.createConcert(new CreateConcertCommand(
                eventDate: new LocalDate(2001,1,1),
                title: null,
                venueName: "Flint Local 432",
                location: "Flint, MI"
            )
        )
        
        concertService.createConcert(new CreateConcertCommand(
                eventDate: new LocalDate(2002,1,1),
                title: "title2",
                venueName: "Flint Local 432",
                location: "Flint, MI"
            )
        )
    }
}