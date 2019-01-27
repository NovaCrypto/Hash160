/*
 *  Hash160
 *  Copyright (C) 2017-2019 Alan Evans, NovaCrypto
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
import static io.github.novacrypto.hashing.Hash160.hash160into;

@RunWith(Parameterized.class)
public final class Hash160intoTests {
    private final byte[] input;
    private final int offset;
    private final byte[] expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"", 0, "b472a266d0bd89c13706a4132ccfb16f7c3b9fcb"},
                {"00", 0, "9f7fd096d37ed2c0e3f7f0cfc924beef4ffceb68"},
                {"01", 0, "c51b66bced5e4491001bd702669770dccf440982"},
                {"0000", 0, "e6c41bcc570872e88e58db7c940dc8d399e72aef"},
                {"ffff", 0, "e6abebacc6bf964f5131e80b241e3fe14bc3e156"},
                {"ab", 0, "2710d55635fd8c42e006137a96ca61cba1a947fc"},
                {"cd", 0, "9aee8b23674a3cea3832872e8d1a5d9447cfa8ff"},
                {"abcd", 0, "4671c47a9d20c240a291661520d4af51df08fb0b"},
                {"abcd", 1, "004671c47a9d20c240a291661520d4af51df08fb0b"},
                {"abcd", 2, "00004671c47a9d20c240a291661520d4af51df08fb0b"}
        });
    }

    public Hash160intoTests(String input, int offset, String expected) {
        this.input = toArray(input);
        this.offset = offset;
        this.expected = toArray(expected);
    }

    @Test
    public void sha256Test() {
        final byte[] actual = new byte[20 + offset];
        hash160into(actual, offset, input);
        assertByteArraysSame(expected, actual);
    }
}