package com.mvvm.examples.data

import com.mvvm.examples.data.local.pref.PrefListener
import com.mvvm.examples.data.online.ApiManager

interface DataManager : PrefListener, ApiManager