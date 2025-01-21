package client;

import static spec.ServerSpecification.getRequestSpecification;

import io.restassured.specification.RequestSpecification;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseTest {
    protected static final RequestSpecification spec = getRequestSpecification();
    protected static DummyClient dummyClient = new DummyClient(spec);
}
