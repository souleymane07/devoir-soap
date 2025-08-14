package com.groupeisi.devoirsoap.endpoint;

import com.groupeisi.devoirsoap.dto.SectorDto;
import com.groupeisi.devoirsoap.models.*;
import com.groupeisi.devoirsoap.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Endpoint
public class SectorEndpoint {

    private static final String NAMESPACE_URI = "http://com.groupeisi/devoirsoap/sectors";

    private final SectorService sectorService;

    @Autowired
    public SectorEndpoint(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSectorRequest")
    @ResponsePayload
    public GetSectorResponse getSector(@RequestPayload GetSectorRequest request) {
        ObjectFactory factory = new ObjectFactory();
        GetSectorResponse response = factory.createGetSectorResponse();
        Optional<SectorDto> sectorDtoOptional = sectorService.getSectorById(request.getId());

        if (sectorDtoOptional.isPresent()) {
            SectorDto sectorDto = sectorDtoOptional.get();
            Sector soapSector = factory.createSector();
            soapSector.setId(sectorDto.getId());
            soapSector.setName(sectorDto.getName());
            response.setSector(soapSector);
        } else {
            response.setSector(null);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllSectorsRequest")
    @ResponsePayload
    public GetAllSectorsResponse getAllSectors() {
        ObjectFactory factory = new ObjectFactory();
        GetAllSectorsResponse response = factory.createGetAllSectorsResponse();

        List<SectorDto> allSectors = sectorService.getAllSectors();
        List<Sector> soapSectors = allSectors.stream()
                .map(sectorDto -> {
                    Sector soapSector = factory.createSector();
                    soapSector.setId(sectorDto.getId());
                    soapSector.setName(sectorDto.getName());
                    // Ajoutez les classes si vous les avez mappées
                    return soapSector;
                })
                .collect(Collectors.toList());

        response.getSectors().addAll(soapSectors);
        return response;
    }

    // NOUVELLE MÉTHODE POUR saveSector
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveSectorRequest")
    @ResponsePayload
    public SaveSectorResponse saveSector(@RequestPayload SaveSectorRequest request) {
        ObjectFactory factory = new ObjectFactory();
        SaveSectorResponse response = factory.createSaveSectorResponse();
        SectorDto sectorDto = new SectorDto();
        sectorDto.setName(request.getName());

        SectorDto savedSector = sectorService.saveSector(sectorDto);

        Sector soapSector = factory.createSector();
        soapSector.setId(savedSector.getId());
        soapSector.setName(savedSector.getName());

        response.setSector(soapSector);
        return response;
    }
}