less = {
  env: "development", // or "production"
  async: false,       // load imports async
  fileAsync: false,   // load imports async when in a page under
                      // a file protocol
  poll: 3000,         // when in watch mode, time in ms between polls
  functions: {},      // user functions, keyed by name
  dumpLineNumbers: "comments", // or "mediaQuery" or "all"
  relativeUrls: false,// whether to adjust url's to be relative
                      // if false, url's are already relative to the
                      // entry less file
};