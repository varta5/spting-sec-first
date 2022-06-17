import models.Example;
import models.ExampleFieldNamesMismatching;
import models.ExampleWithLimitedMatchingFields;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.internal.MappingEngineImpl;
import org.modelmapper.spi.Mapping;
import org.modelmapper.spi.MappingEngine;

import java.util.List;

public class PracticeModelMapper {

    public static void main(String[] args) {
        Example example = new Example(1, 123, "This is example test", true,
                List.of("One text", "Another text", "Third and last text"));
        // ExampleWithLimitedMatchingFields exampleWithLimitedMatchingFields = convertExampleToLimitedFields(example);
        // ModelMapper modelMapper = new ModelMapper();
        // TypeMap<Example, ExampleFieldNamesMismatching> typeMap = modelMapper.createTypeMap(Example.class, ExampleFieldNamesMismatching.class);
        ExampleFieldNamesMismatching exampleFieldNamesMismatching = convertExampleToFieldNamesMismatching(example);

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
}
