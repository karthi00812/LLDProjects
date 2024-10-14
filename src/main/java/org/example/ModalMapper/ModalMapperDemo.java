package org.example.ModalMapper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;

public class ModalMapperDemo {
    public static void modalMapperDemo() {

        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setEmail("email");
        userEntity.setFirstName("Karthik");
        userEntity.setLastName("keyan");

        // Mapping based on the field names
        ModelMapper modelMapperField = new ModelMapper();
        UserDTO userDTO = modelMapperField.map(userEntity, UserDTO.class);
        System.out.println("Field Mapping");
        System.out.println(userDTO.toString());

        // custom mapping based on the filed, no extra logic
        ModelMapper modelMapperCustom = new ModelMapper();
        modelMapperCustom.addMappings(new PropertyMap<UserEntity, UserDTO>() {
            @Override
            protected void configure() {
                map().setEmailAddress(source.getEmail());
                map().setFullName(source.getFirstName());
            }
        });
        UserDTO userDTO1 = modelMapperCustom.map(userEntity, UserDTO.class);
        System.out.println("Custom Property mapping");
        System.out.println(userDTO1.toString());

        // custom mapping based on converter, in converter we can add custom logic.
        ModelMapper modelMapperConverter = new ModelMapper();

        Converter<String, String> toUpperCaseConverter = new Converter<String, String>() {
            public String convert(MappingContext<String, String> context) {
                System.out.println(1);
                return context.getSource() == null ? null : context.getSource().toUpperCase() + "JIO";
            }
        };

        // Apply the custom converter
        modelMapperConverter.typeMap(UserEntity.class, UserDTO.class).addMappings(mapper -> {
            mapper.using(toUpperCaseConverter)
                    .map(UserEntity::getFirstName, UserDTO::setFullName);
            mapper.using(toUpperCaseConverter).map(UserEntity::getEmail, UserDTO::setEmailAddress);
        });

        UserDTO userDTO2 = modelMapperConverter.map(userEntity, UserDTO.class);
        System.out.println(userDTO2.toString());

    }
}
