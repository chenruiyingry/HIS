import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.his.core.model.AlipayModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class TestAli {

	@Test
	public void test() {
		AlipayModel model = new AlipayModel();
		System.out.println(model);
		System.out.println(model.getOpen_api_domain());
	}
}
