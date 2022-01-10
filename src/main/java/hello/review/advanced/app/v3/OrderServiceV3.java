package hello.review.advanced.app.v3;

import hello.review.advanced.trace.TraceId;
import hello.review.advanced.trace.TraceStatus;
import hello.review.advanced.trace.hellotrace.HelloTraceV2;
import hello.review.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.request()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch(Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
