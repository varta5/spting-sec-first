import models.Example;
import models.ExampleFieldNamesMismatching;
import models.ExampleWithConversion;
import models.ExampleWithLimitedMatchingFields;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.util.List;

public class PracticeModelMapper {

    public static void main(String[] args) {
        Example example = new Example(1, 123, "g", true,
                List.of("One text", "Another text", "Third", "Fourth 4 yeah", "", "Last one if the sixth!"));
        // ExampleWithLimitedMatchingFields exampleWithLimitedMatchingFields = convertExampleToLimitedFields(example);
        // ExampleFieldNamesMismatching exampleFieldNamesMismatching = convertExampleToFieldNamesMismatching(example);
        // ExampleWithConversion exampleWithConversion = modelMapper.map(example, ExampleWithConversion.class);
        // ExampleWithConversion exampleWithConversion = convertFields(example);

        System.out.println("Done.");
    }

    public static ExampleWithLimitedMatchingFields convertExampleToLimitedFields(Example example) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(example, ExampleWithLimitedMatchingFields.class);
    }

    public static ExampleFieldNamesMismatching convertExampleToFieldNamesMismatching(Example example) {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<Example, ExampleFieldNamesMismatching> typeMap = modelMapper.createTypeMap(Example.class, ExampleFieldNamesMismatching.class);
        typeMap.addMapping(Example::getaNumber, ExampleFieldNamesMismatching::setThisIsANumber);
        typeMap.addMapping(Example::getText, ExampleFieldNamesMismatching::setThisIsAText);
        typeMap.addMapping(Example::isAwesome, ExampleFieldNamesMismatching::setThisIsABoolean);
        typeMap.addMapping(Example::getListOfWords, ExampleFieldNamesMismatching::setThisIsAListOfStrings);
        return modelMapper.map(example, ExampleFieldNamesMismatching.class);
    }

    public static ExampleWithConversion convertFields(Example example) {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<Example, ExampleWithConversion> typeMap = modelMapper.createTypeMap(Example.class, ExampleWithConversion.class);
        Converter<Integer, Integer> doublingNumber = new AbstractConverter<Integer, Integer>() {
            @Override
            protected Integer convert(Integer source) {
                return source == null ? null : source * 2;
            }
        };
        typeMap.addMappings(src -> src.using(doublingNumber).map(Example::getaNumber, ExampleWithConversion::setaNumber));
        Converter<String, Character> getLastCharacterOfText = new AbstractConverter<String, Character>() {
            @Override
            protected Character convert(String source) {
                if (source == null || source.isEmpty()) {
                    return null;
                }
                return source.charAt(source.length() - 1);
            }
        };
        typeMap.addMappings(src -> src.using(getLastCharacterOfText).map(Example::getText, ExampleWithConversion::setLastCharacterOfText));
        Converter<List<String>, Integer> countOfStrings = new AbstractConverter<List<String>, Integer>() {
            @Override
            protected Integer convert(List<String> source) {
                if (source == null) {
                    return 0;
                }
                return source.size();
            }
        };
        typeMap.addMappings(src -> src.using(countOfStrings).map(Example::getListOfWords, ExampleWithConversion::setNumberOfStrings));
        return modelMapper.map(example, ExampleWithConversion.class);
    }
}
