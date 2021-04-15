package com;

import java.io.IOException;

class WebsiteTest {

    Website site;

    public WebsiteTest() {
        site = new Website("https://en.wikipedia.org/wiki/Russia");

    }

    void testOpenHTML() throws IOException {
        site.openHTML();
    }
}