package io.github.znetworkw.znpcservers.skin.internal;

import io.github.znetworkw.znpcservers.skin.SkinFetcherResult;

/**
 * @author Gaston Gonzalez {@literal <znetworkw.dev@gmail.com>}
 */
public class DefaultSkinFetcherResultBuilder implements SkinFetcherResult.SkinFetcherResultBuilder {
    private static final String EMPTY_STRING = "";

    private final String texture, signature;

    private DefaultSkinFetcherResultBuilder(String texture, String signature) {
        this.texture = texture;
        this.signature = signature;
    }

    public DefaultSkinFetcherResultBuilder() {
        this(EMPTY_STRING, EMPTY_STRING);
    }

    @Override
    public SkinFetcherResult.SkinFetcherResultBuilder withTexture(String texture) {
        return new DefaultSkinFetcherResultBuilder(texture, signature);
    }

    @Override
    public SkinFetcherResult.SkinFetcherResultBuilder withSignature(String signature) {
        return new DefaultSkinFetcherResultBuilder(texture, signature);
    }

    @Override
    public SkinFetcherResult build() {
        return new SkinFetcherResult() {
            @Override
            public String getTexture() {
                return texture;
            }

            @Override
            public String getSignature() {
                return signature;
            }
        };
    }
}
