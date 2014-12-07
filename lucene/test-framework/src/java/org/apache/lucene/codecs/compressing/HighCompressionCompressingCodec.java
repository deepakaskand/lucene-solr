package org.apache.lucene.codecs.compressing;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/** CompressionCodec that uses {@link CompressionMode#HIGH_COMPRESSION} */
public class HighCompressionCompressingCodec extends CompressingCodec {

  /** Constructor that allows to configure the chunk size. */
  public HighCompressionCompressingCodec(int chunkSize, int maxDocsPerChunk, boolean withSegmentSuffix) {
    super("HighCompressionCompressingStoredFields",
          withSegmentSuffix ? "HighCompressionCompressingStoredFields" : "",
          CompressionMode.HIGH_COMPRESSION, chunkSize, maxDocsPerChunk);
  }

  /** Default constructor. */
  public HighCompressionCompressingCodec() {
    // no need to have a higher block length than 32KB since deflate splits
    // into blocks of 32KB anyway, and this is a lower bound (try to avoid > 32KB)
    this(24576, 512, false);
  }
}
