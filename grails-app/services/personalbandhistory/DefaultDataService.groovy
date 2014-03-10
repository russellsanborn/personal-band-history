package personalbandhistory

import org.joda.time.LocalDate

class DefaultDataService {
    
    BandService bandService
    SongService songService
    
    def loadDefaultDevData() {
        
        // Create test bands
        bandService.createBand(new CreateBandCommand(
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
        
    }
}