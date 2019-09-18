package config.controllers;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.uber.jaeger.Configuration;
import com.uber.jaeger.samplers.ProbabilisticSampler;

import brave.Tracing;
import brave.opentracing.BraveTracer;
import brave.sampler.Sampler;
import zipkin.Span;
import zipkin.reporter.AsyncReporter;
import zipkin.reporter.Encoding;
import zipkin.reporter.okhttp3.OkHttpSender;

@org.springframework.context.annotation.Configuration
public class JaegerConfig {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

//	@Bean
	public io.opentracing.Tracer jaegerTracer() {
		return new Configuration("poc2-resources", new Configuration.SamplerConfiguration(ProbabilisticSampler.TYPE, 1),
				new Configuration.ReporterConfiguration()).getTracer();
	}

	@Bean
	public io.opentracing.Tracer zipkinTracer() {
		OkHttpSender okHttpSender = OkHttpSender.builder().encoding(Encoding.JSON)
				.endpoint("http://localhost:9411/api/v1/spans").build();
		AsyncReporter<Span> reporter = AsyncReporter.builder(okHttpSender).build();
		Tracing braveTracer = Tracing.newBuilder().localServiceName("poc2-resources").reporter(reporter)
				.traceId128Bit(true).sampler(Sampler.ALWAYS_SAMPLE).build();
		return BraveTracer.create(braveTracer);
	}
}
