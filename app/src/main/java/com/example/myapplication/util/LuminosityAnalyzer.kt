package com.example.myapplication.util

import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import java.nio.ByteBuffer

typealias LumaListener = (luma: Double) -> Unit
// analyzer is one of the use cale of cameraX but I do not know why is it useful
class LuminosityAnalyzer(private val listener: LumaListener) :ImageAnalysis.Analyzer {
    // slow down analysis
    var latestAnalyzerTimestamp = 0L
    val maxFps = 10

    private fun ByteBuffer.toByteArray(): ByteArray{
        rewind()  // rewind the buffer to zero
        val data  = ByteArray(remaining())
        get(data)
        return data

    }
    override fun analyze(image: ImageProxy) {

        if(image.imageInfo.timestamp - latestAnalyzerTimestamp < 1000/maxFps){
            image.close()
            }
        val buffer = image.planes[0].buffer
        val data = buffer.toByteArray()
        val pixels = data.map {
            it.toInt() and 0xFF
        }
        val luma = pixels.average()
        listener(luma)
        image.close()
        latestAnalyzerTimestamp = image.imageInfo.timestamp
    }

}