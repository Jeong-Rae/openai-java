// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.threads

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.BetaThreadMessageCreateParams
import com.openai.models.BetaThreadMessageDeleteParams
import com.openai.models.BetaThreadMessageListParams
import com.openai.models.BetaThreadMessageRetrieveParams
import com.openai.models.BetaThreadMessageUpdateParams
import com.openai.models.CodeInterpreterTool
import com.openai.models.Metadata
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class MessageServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageService = client.beta().threads().messages()

        val message =
            messageService.create(
                BetaThreadMessageCreateParams.builder()
                    .threadId("thread_id")
                    .content("string")
                    .role(BetaThreadMessageCreateParams.Role.USER)
                    .addAttachment(
                        BetaThreadMessageCreateParams.Attachment.builder()
                            .fileId("file_id")
                            .addTool(CodeInterpreterTool.builder().build())
                            .build()
                    )
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        message.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageService = client.beta().threads().messages()

        val message =
            messageService.retrieve(
                BetaThreadMessageRetrieveParams.builder()
                    .threadId("thread_id")
                    .messageId("message_id")
                    .build()
            )

        message.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageService = client.beta().threads().messages()

        val message =
            messageService.update(
                BetaThreadMessageUpdateParams.builder()
                    .threadId("thread_id")
                    .messageId("message_id")
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        message.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageService = client.beta().threads().messages()

        val page =
            messageService.list(BetaThreadMessageListParams.builder().threadId("thread_id").build())

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageService = client.beta().threads().messages()

        val messageDeleted =
            messageService.delete(
                BetaThreadMessageDeleteParams.builder()
                    .threadId("thread_id")
                    .messageId("message_id")
                    .build()
            )

        messageDeleted.validate()
    }
}
