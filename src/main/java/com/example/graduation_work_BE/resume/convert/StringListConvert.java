package com.example.graduation_work_BE.resume.convert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;

import java.util.List;
import java.util.Map;

@Convert
public class StringListConvert implements AttributeConverter<List<String>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    // entity 속성 값을 DB에 저장하기 전 리스트를 스트링으로 변환
    @Override
    public String convertToDatabaseColumn(List<String> dateList){
        try {
            return objectMapper.writeValueAsString(dateList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    // DB에서 읽어온 데이터를 entity를 입력하기 전 스트링을 리스트로 변환
    @Override
    public List<String> convertToEntityAttribute(String data){
        try {
            return objectMapper.readValue(data, List.class);
        } catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}

