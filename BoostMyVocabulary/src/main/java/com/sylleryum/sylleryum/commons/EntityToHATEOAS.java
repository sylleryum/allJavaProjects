package com.sylleryum.sylleryum.commons;

import org.springframework.data.domain.Page;


public class EntityToHATEOAS {

//    public static void estadoToHATEOAS(Estado estado) throws ResourceNotFoundException {
//        HATEOASBuilder.linksBuilder(estado, EstadoController.class, "estados");
//        HATEOASBuilder.linksBuilderNestedEntity(estado.getCidades(), CidadeController.class, "cidades");
//    }
//
//    public static void cidadeToHATEOAS(Cidade cidade) throws ResourceNotFoundException {
//        HATEOASBuilder.linksBuilder(cidade, CidadeController.class, "cidades");
//        HATEOASBuilder.linksBuilderNestedEntity(cidade.getInstituicoes(), CidadeController.class, "instituições");
//    }
//
//    public static void instituicaoToHATEOAS(Instituicao instituicao) throws ResourceNotFoundException {
//        HATEOASBuilder.linksBuilder(instituicao, InstituicaoController.class, "cidades");
//        //HATEOASBuilder.linksBuilderNestedEntity(instituicao.getInstituicoes(), CidadeController.class, "instituições");
//    }
//
//    public static void instituicoesToHATEOAS(Page<Instituicao> instituicoes) throws ResourceNotFoundException {
//        instituicoes.forEach(i -> {
//            try {
//                instituicaoToHATEOAS(i);
//            } catch (ResourceNotFoundException e) {
//
//            }
//        });
//    }

}
