/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.index.similarity;

import org.apache.lucene.search.similarities.Similarity;

/**
 * Wrapper around a {@link Similarity} and its name.
 */
public final class SimilarityProvider {

    private final String name;
    private final Similarity similarity;

    public SimilarityProvider(String name, Similarity similarity) {
        this.name = name;
        this.similarity = similarity;
    }

    /**
     * Return the name of this {@link Similarity}.
     */
    public String name() {
        return name;
    }

    /**
     * Return the wrapped {@link Similarity}.
     */
    public Similarity get() {
        return similarity;
    }
    
     /*
   * Compute the hashcode on name {@link Similarity}.
   */
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      return result;
   }

   /*
   * Check if SimilarityProvider reference or name are equals {@link Similarity}.
   */
   @Override
   public boolean equals(final Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
         return false;
      }

      SimilarityProvider other = (SimilarityProvider) obj;
      if (name == null) {
         if (other.name != null) {
            return false;
         }
      } else if (!name.equals(other.name)) {
         return false;
      }
      return true;
   }

}
