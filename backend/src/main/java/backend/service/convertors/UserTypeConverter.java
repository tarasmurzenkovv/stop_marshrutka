package backend.service.convertors;

import backend.model.dto.UserType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UserTypeConverter implements AttributeConverter<UserType, String> {

  @Override
  public String convertToDatabaseColumn(UserType userType) {
    return userType.getType();
  }

  @Override
  public UserType convertToEntityAttribute(String value) {
    return UserType.fromValue(value);
  }
}
