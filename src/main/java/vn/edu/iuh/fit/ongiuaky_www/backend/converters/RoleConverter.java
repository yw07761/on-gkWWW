package vn.edu.iuh.fit.ongiuaky_www.backend.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.ongiuaky_www.backend.enums.Roles;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Roles, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Roles attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getRole();
    }

    @Override
    public Roles convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }

        return Stream.of(Roles.values())
                .filter(c -> c.getRole() == dbData)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

