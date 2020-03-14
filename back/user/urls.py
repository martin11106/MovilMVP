from django.urls import path, re_path
from django.conf.urls import include
from django.contrib.auth.models import User
from user import views

urlpatterns = [

    re_path(r'/user_list/$', views.userList.as_view()),#/alumno+ aqui agrego hacia donde quiero
     re_path(r'/user_detail/(?P<id>[\w\-]+)/$',views.userDetail.as_view()),#/str para
]
