// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaThreadRunSubmitToolOutputsParamsTest {

    @Test
    fun create() {
        BetaThreadRunSubmitToolOutputsParams.builder()
            .threadId("thread_id")
            .runId("run_id")
            .addToolOutput(
                BetaThreadRunSubmitToolOutputsParams.ToolOutput.builder()
                    .output("output")
                    .toolCallId("tool_call_id")
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            BetaThreadRunSubmitToolOutputsParams.builder()
                .threadId("thread_id")
                .runId("run_id")
                .addToolOutput(
                    BetaThreadRunSubmitToolOutputsParams.ToolOutput.builder()
                        .output("output")
                        .toolCallId("tool_call_id")
                        .build()
                )
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.toolOutputs())
            .isEqualTo(
                listOf(
                    BetaThreadRunSubmitToolOutputsParams.ToolOutput.builder()
                        .output("output")
                        .toolCallId("tool_call_id")
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            BetaThreadRunSubmitToolOutputsParams.builder()
                .threadId("thread_id")
                .runId("run_id")
                .addToolOutput(BetaThreadRunSubmitToolOutputsParams.ToolOutput.builder().build())
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.toolOutputs())
            .isEqualTo(listOf(BetaThreadRunSubmitToolOutputsParams.ToolOutput.builder().build()))
    }

    @Test
    fun getPathParam() {
        val params =
            BetaThreadRunSubmitToolOutputsParams.builder()
                .threadId("thread_id")
                .runId("run_id")
                .addToolOutput(BetaThreadRunSubmitToolOutputsParams.ToolOutput.builder().build())
                .build()
        assertThat(params).isNotNull
        // path param "threadId"
        assertThat(params.getPathParam(0)).isEqualTo("thread_id")
        // path param "runId"
        assertThat(params.getPathParam(1)).isEqualTo("run_id")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
