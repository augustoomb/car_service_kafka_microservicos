package com.portal.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // LOMBOK QUE CRIA OS GETTERS AND SETTERS
@Builder // LOMBOK QUE ME PERMITE CRIAR INSTÂNCIA COM SOMENTE OS ATRIBUTOS QUE EU ESCOLHER NA HORA
@NoArgsConstructor // LOMBOK QUE CRIA CONSTRUTOR COM NENHUMATRIBUTO
@AllArgsConstructor // LOMBOK QUE CRIA CONSTRUTOR COM TODOS OS ATRIBUTOS
@JsonInclude // TRABALHAR COM JSON
public class OwnerPostDTO {

    private String name;
    private String type;
    private String contactNumber;
}
