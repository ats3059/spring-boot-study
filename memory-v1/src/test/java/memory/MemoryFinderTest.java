package memory;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemoryFinderTest {

    @Test
    public void MemoryFinderTest() throws Exception{
        //given
        MemoryFinder memoryFinder = new MemoryFinder();

        //when
        Memory memory = memoryFinder.get();

        //then
        Assertions.assertThat(memory).isNotNull();

    }

}