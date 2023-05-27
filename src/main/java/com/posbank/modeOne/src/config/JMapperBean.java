//package com.posbank.modeOne.src.config;
//
//
//import com.googlecode.jmapper.JMapper;
//import com.googlecode.jmapper.api.JMapperAPI;
//import com.posbank.modeOne.src.dto.ContaCorrenteDTO;
//import com.posbank.modeOne.src.service.ContaCorrente;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import static com.googlecode.jmapper.api.JMapperAPI.attribute;
//
//@Configuration
//public class JMapperBean {
//    @Bean
//    public JMapper<ContaCorrente, ContaCorrenteDTO> contaCorrenteMapper() {
//        JMapperAPI jMapperAPI = new JMapperAPI()
//                .add(JMapperAPI.mappedClass(ContaCorrente.class)
//                        .add(attribute("banco").value("banco"))
//                        .add(attribute("agencia").value("agencia"))
//                        .add(attribute("numero").value("numero")));
//        return new JMapper<>(ContaCorrente.class, ContaCorrenteDTO.class, jMapperAPI);
//    }
//}
