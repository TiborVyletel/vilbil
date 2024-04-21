package vilbil.application.aws.lambda

import com.amazonaws.serverless.proxy.model.AwsProxyRequest
import com.amazonaws.serverless.proxy.model.AwsProxyResponse
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler
import com.amazonaws.serverless.proxy.spring.SpringBootProxyHandlerBuilder
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestStreamHandler
import java.io.InputStream
import java.io.OutputStream
import vilbil.application.VilbilApplication

class StreamLambdaHandler : RequestStreamHandler {

  companion object {
    val handler: SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> =
      SpringBootProxyHandlerBuilder<AwsProxyRequest>()
        .defaultProxy()
        .springBootApplication(VilbilApplication::class.java)
        .buildAndInitialize()
    //            SpringBootLambdaContainerHandler.getAwsProxyHandler()

  }

  override fun handleRequest(inputStream: InputStream, outputStream: OutputStream, ctx: Context) {
    handler.proxyStream(inputStream, outputStream, ctx)
  }
}
