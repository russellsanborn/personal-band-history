package personalbandhistory

import org.joda.time.LocalDate

class BandController {
    def scaffold = true
    
    def index () {
        redirect(action: "list")
    }    
    
    def list() {
        [bands: Band.listOrderByName()]
    }
    
    def show(Long id) {
        Band band = Band.get(id)

        if (!band) {
            redirect uri: '/'
        }

        [band: band, 
        members: band.members.sort {it.name},
        albums: band.albums.sort {it.name}]
    }
    
    def band_image() {
        def band = Band.get(params.id)
        if (!band) {
          response.sendError(404)
          return
        }
        OutputStream out = response.outputStream
        out.write(band?.bandImage)
        out.close()
    }
}

class CreateBandCommand {
    String bio
    String name
    String location
    LocalDate startDate
    LocalDate endDate
}
