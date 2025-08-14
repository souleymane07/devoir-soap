package com.groupeisi.devoirsoap.endpoint;

import com.groupeisi.devoirsoap.dto.ClasseDto;
import com.groupeisi.devoirsoap.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.groupeisi.devoirsoap.models.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Endpoint
public class ClasseEndpoint {

    private static final String NAMESPACE_URI = "http://com.groupeisi/devoirsoap/classes";

    private final ClasseService classeService;

    @Autowired
    public ClasseEndpoint(ClasseService classeService) {
        this.classeService = classeService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClasseRequest")
    @ResponsePayload
    public GetClasseResponse getClasse(@RequestPayload GetClasseRequest request) {
        ObjectFactory factory = new ObjectFactory();
        GetClasseResponse response = factory.createGetClasseResponse();

        Optional<ClasseDto> classeDtoOptional = classeService.getClasseById(request.getId());

        if (classeDtoOptional.isPresent()) {
            ClasseDto classeDto = classeDtoOptional.get();
            Classe soapClasse = factory.createClasse();
            soapClasse.setId(classeDto.getId());
            soapClasse.setClassName(classeDto.getClassName());
            soapClasse.setDescription(classeDto.getDescription());
            response.setClasse(soapClasse);
        } else {
            response.setClasse(null);
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllClassesRequest")
    @ResponsePayload
    public GetAllClassesResponse getAllClasses(@RequestPayload GetAllClassesRequest request) {
        ObjectFactory factory = new ObjectFactory();
        GetAllClassesResponse response = factory.createGetAllClassesResponse();

        List<ClasseDto> allClasses = classeService.getAllClasses();
        List<Classe> soapClasses = allClasses.stream()
                .map(classeDto -> {
                    Classe soapClasse = factory.createClasse();
                    soapClasse.setId(classeDto.getId());
                    soapClasse.setClassName(classeDto.getClassName());
                    soapClasse.setDescription(classeDto.getDescription());
                    return soapClasse;
                })
                .collect(Collectors.toList());

        response.getClasses().addAll(soapClasses);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveClasseRequest")
    @ResponsePayload
    public SaveClasseResponse saveClasse(@RequestPayload SaveClasseRequest request) {
        ObjectFactory factory = new ObjectFactory();
        SaveClasseResponse response = factory.createSaveClasseResponse();

        ClasseDto newClasseDto = new ClasseDto();
        newClasseDto.setClassName(request.getClassName());
        newClasseDto.setDescription(request.getDescription());
        newClasseDto.setSectorId(request.getSectorId());

        ClasseDto savedClasseDto = classeService.saveClasse(newClasseDto);

        Classe soapClasse = factory.createClasse();
        soapClasse.setId(savedClasseDto.getId());
        soapClasse.setClassName(savedClasseDto.getClassName());
        soapClasse.setDescription(savedClasseDto.getDescription());

        response.setClasse(soapClasse);

        return response;
    }
}