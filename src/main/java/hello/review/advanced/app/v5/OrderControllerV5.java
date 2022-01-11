package hello.review.advanced.app.v5;

import hello.review.advanced.trace.callback.TraceCallback;
import hello.review.advanced.trace.callback.TraceTemplate;
import hello.review.advanced.trace.logtrace.LogTrace;
import hello.review.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.tools.Trace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate traceTemplate;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.traceTemplate = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return traceTemplate.execute("OrderController.request()", new TraceCallback<>() {
            @Override
            public String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        });

    }
}
