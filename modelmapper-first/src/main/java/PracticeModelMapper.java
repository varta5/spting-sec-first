import models.Example;

import java.util.List;

public class PracticeModelMapper {
    public static void main(String[] args) {
        Example example = new Example(1, 123, "This is example test", true,
                List.of("One text", "Another text", "Third and last text"));
        System.out.println("Done.");
    }
}
