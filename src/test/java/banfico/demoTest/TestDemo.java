package banfico.demoTest;

import org.example.ModalMapper.ModalMapperDemo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class)
public class TestDemo {

    @Mock
    ModalMapperDemo modalMapperDemo;

    @Test
    public void demo() {
        modalMapperDemo.test();
        Assert.assertEquals(1, 2);
    }
}
