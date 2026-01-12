package com.portal.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    AS ANOTATIONS DO LOMBOK AJUDAM PARA QUE EU NÃO PRECISE FICAR ESCREVENDO GETTER, SETTER, CONTRUTORES E ETC.
    JÁ FAZ TUDO AUTOMATICAMENTE E DEIXO IMPLÍCITO
 */

@Data  // LOMBOK QUE CRIA OS GETTERS AND SETTERS
@Builder // LOMBOK QUE ME PERMITE CRIAR INSTÂNCIA COM SOMENTE OS ATRIBUTOS QUE EU ESCOLHER NA HORA
@NoArgsConstructor // LOMBOK QUE CRIA CONSTRUTOR COM NENHUMATRIBUTO
@AllArgsConstructor // LOMBOK QUE CRIA CONSTRUTOR COM TODOS OS ATRIBUTOS
@JsonInclude // TRABALHAR COM JSON
public class CarPostDTO {

    private String model;

    private String brand;

    private String price;

    private String description;

    private String engineVersion;

    private String city;

    private String createDate;

    private Long ownerId;

    private String ownerName;

    private String ownerType;

    private String contact;

}
