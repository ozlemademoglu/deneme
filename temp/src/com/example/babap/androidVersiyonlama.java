class AsyncTaskClass extends AsyncTask<String, String, String> {
		 
        @Override
        protected void onPreExecute() {
            /*ToastFK("BASLIYOR");*/
        }
 
        @Override
        protected String doInBackground(String... strings) {
 
 
            return null;
        }
 
        @Override
        protected void onPostExecute(String s) {
        	/*ToastFK("BITTI");*/
        	
        }
        
    }