package personalbandhistory

import org.joda.time.LocalDate

class BandService {

    Band createBand (CreateBandCommand cmd) {
        new Band(
            bio: cmd.bio,
            name: cmd.name,
            location: cmd.location,
            startDate: cmd.startDate,
            endDate: cmd.endDate
        ).save()
    }
    
    Album addAlbum(Band band, String name, LocalDate releaseDate) {
        Album newAlbum = new Album (
            name: name,
            releaseDate: releaseDate,
            band: band
        ).save()
        
        band.addToAlbums(newAlbum)
        return newAlbum
    }
    
    Member addMember(Band band, String name, String instrument, LocalDate startDate, LocalDate endDate) {
        Member newMember = new Member (
            name: name,
            instrument: instrument,
            startDate: startDate,
            endDate: endDate
        ).save()
        
        band.addToMembers(newMember)
        return newMember
    }
}
