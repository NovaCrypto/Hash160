/*
 *  Hash160
 *  Copyright (C) 2017-2018 Alan Evans, NovaCrypto
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 *  Original source: https://github.com/NovaCrypto/Hash160
 *  You can contact the authors via github issues.
 */

package io.github.novacrypto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static io.github.novacrypto.Asserts.assertByteArraysSame;
import static io.github.novacrypto.Hex.toArray;
import static io.github.novacrypto.hashing.Hash160.hash160;

@RunWith(Parameterized.class)
public final class Hash160Tests {
    private final byte[] input;
    private final byte[] expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"", "b472a266d0bd89c13706a4132ccfb16f7c3b9fcb"},
                {"00", "9f7fd096d37ed2c0e3f7f0cfc924beef4ffceb68"},
                {"01", "c51b66bced5e4491001bd702669770dccf440982"},
                {"0000", "e6c41bcc570872e88e58db7c940dc8d399e72aef"},
                {"ffff", "e6abebacc6bf964f5131e80b241e3fe14bc3e156"}
        });
    }

    public Hash160Tests(String input, String expected) {
        this.input = toArray(input);
        this.expected = toArray(expected);
    }

    @Test
    public void hash160Test() {
        assertByteArraysSame(expected, hash160(input));
    }
}
